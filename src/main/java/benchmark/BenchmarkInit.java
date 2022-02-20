package benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public class BenchmarkInit {

    @Param({ "1000000" })
    public static int ARRAY_SIZE;

    @Setup
    public void setup() {
    }

    @Benchmark
    public void initArrayInt(Blackhole bh) {
        int[] ints = new int[ARRAY_SIZE];
        bh.consume(ints);
    }

    @Benchmark
    public void initArrayInteger(Blackhole bh) {
        Integer[] integers = new Integer[ARRAY_SIZE];
        bh.consume(integers);
    }

    @Benchmark
    public void initArrayIntegerActual(Blackhole bh) {
        IntegerActual[] integersActual = new IntegerActual[ARRAY_SIZE];
        bh.consume(integersActual);
    }

    @Benchmark
    public void initArrayIntegerPrimitive(Blackhole bh) {
        IntegerPrimitive[] integersPrimitive = new IntegerPrimitive[ARRAY_SIZE];
        bh.consume(integersPrimitive);
    }

    @Benchmark
    public void initArrayIntegerValue(Blackhole bh) {
        IntegerValue[] integersValue = new IntegerValue[ARRAY_SIZE];
        bh.consume(integersValue);
    }

    @Benchmark
    public void initArrayListInteger(Blackhole bh) {
        List<Integer> integers = new ArrayList<>(ARRAY_SIZE);
        bh.consume(integers);
    }

    @Benchmark
    public void initArrayListIntegerActual(Blackhole bh) {
        List<IntegerActual> integersActual = new ArrayList<>(ARRAY_SIZE);
        bh.consume(integersActual);
    }

    @Benchmark
    public void initArrayListIntegerValue(Blackhole bh) {
        List<IntegerValue> integersValue = new ArrayList<>(ARRAY_SIZE);
        bh.consume(integersValue);
    }

}
