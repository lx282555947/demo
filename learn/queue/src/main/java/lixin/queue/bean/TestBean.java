package lixin.queue.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestBean implements Delayed {

    private long executeTimestamp;

    private long seq;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTimestamp - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        // http://www.csplib.org/Problems/prob007/

        int N = 100;
// 1. Modelling part
        Model model = new Model("all-interval series of size "+ N);
// 1.a declare the variables
        IntVar[] S = model.intVarArray("s", N, 0, N - 1, false);
        IntVar[] V = model.intVarArray("V", N - 1, 1, N - 1, false);
// 1.b post the constraints
        for (int i = 0; i < N - 1; i++) {
            model.distance(S[i + 1], S[i], "=", V[i]).post();
        }
        model.allDifferent(S).post();
        model.allDifferent(V).post();
        S[1].gt(S[0]).post();
        V[1].gt(V[N - 2]).post();

// 2. Solving part
        Solver solver = model.getSolver();
// 2.a define a search strategy
        solver.setSearch(Search.minDomLBSearch(S));
        if(solver.solve()){
            System.out.printf("All interval series of size %d%n", N);
            for (int i = 0; i < N - 1; i++) {
                System.out.printf("%d <%d> ",
                        S[i].getValue(),
                        V[i].getValue());
            }
            System.out.printf("%d", S[N - 1].getValue());
        }
    }
}
