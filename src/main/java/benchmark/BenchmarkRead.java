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
public class BenchmarkRead {

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
            for (int i = 0; i < ARRAY_SIZE; i++) {
                ints[i] = i;
            }
            integers = new Integer[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integers[i] = i;
            }
            integersActual = new IntegerActual[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersActual[i] = new IntegerActual(i);
            }
            integersPrimitive = new IntegerPrimitive[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersPrimitive[i] = new IntegerPrimitive(i);
            }
            integersValue = new IntegerValue[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersValue[i] = new IntegerValue(i);
            }
            integersList = new ArrayList<>(ARRAY_SIZE);
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersList.add(i);
            }
            integersActualList = new ArrayList<>(ARRAY_SIZE);
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersActualList.add(new IntegerActual(i));
            }
            integersValueList = new ArrayList<>(ARRAY_SIZE);
            for (int i = 0; i < ARRAY_SIZE; i++) {
                integersValueList.add(new IntegerValue(i));
            }
        }
    }

    int[] consumeInts;

    @Setup
    public void setup(MyState state) {
        consumeInts = new int[ARRAY_SIZE];
    }

    @Benchmark
    public void readArrayInt(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.ints[i];
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayInteger(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integers[i];
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayIntegerActual(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersActual[i].value();
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayIntegerPrimitive(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersPrimitive[i].value();
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayIntegerValue(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersValue[i].value();
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayListInteger(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersList.get(i);
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayListIntegerActual(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersActualList.get(i).value();
        }
        bh.consume(consumeInts);
    }

    @Benchmark
    public void readArrayListIntegerValue(Blackhole bh, MyState state) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            consumeInts[i] = state.integersValueList.get(i).value();
        }
        bh.consume(consumeInts);
    }

}
