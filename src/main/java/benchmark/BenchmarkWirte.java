package benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
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
public class BenchmarkWirte {

    @Param({ "1000000" })
    public static int ARRAY_SIZE;

    @State(Scope.Thread)
    public static class MyState {
        int[] ints;
        Integer[] integers;
        IntegerActual[] integersActual;
        IntegerPrimitive[] integersPrimitive;
        IntegerValue[] integersValue;
        List<Integer> integersList;
        List<IntegerActual> integersActualList;
        List<IntegerValue> integersValueList;

        @Setup(Level.Iteration)
        public void setup() {
            ints = new int[ARRAY_SIZE];
            integers = new Integer[ARRAY_SIZE];
            integersActual = new IntegerActual[ARRAY_SIZE];
            integersPrimitive = new IntegerPrimitive[ARRAY_SIZE];
            integersValue = new IntegerValue[ARRAY_SIZE];
            integersList = new ArrayList<>(ARRAY_SIZE);
            integersActualList = new ArrayList<>(ARRAY_SIZE);
            integersValueList = new ArrayList<>(ARRAY_SIZE);
        }
    }

    @Benchmark
    public void writeArrayInt(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.ints[i] = i;
        }
        bh.consume(state.ints);
    }

    @Benchmark
    public void writeArrayInteger(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integers[i] = i;
        }
        bh.consume(state.integers);
    }

    @Benchmark
    public void writeArrayIntegerActual(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersActual[i] = new IntegerActual(i);
        }
        bh.consume(state.integersActual);
    }

    @Benchmark
    public void writeArrayIntegerPrimitive(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersPrimitive[i] = new IntegerPrimitive(i);
        }
        bh.consume(state.integersPrimitive);
    }

    @Benchmark
    public void writeArrayIntegerValue(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersValue[i] = new IntegerValue(i);
        }
        bh.consume(state.integersValue);
    }

    @Benchmark
    @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    public void writeArrayListInteger(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersList.add(i);
        }
        bh.consume(state.integersList);
    }

    @Benchmark
    @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    public void writeArrayListIntegerActual(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersActualList.add(new IntegerActual(i));
        }
        bh.consume(state.integersActualList);
    }

    @Benchmark
    @Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
    public void writeArrayListIntegerValue(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            state.integersValueList.add(new IntegerValue(i));
        }
        bh.consume(state.integersValueList);
    }

}
