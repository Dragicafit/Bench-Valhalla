# Bench-Valhalla

| Benchmark                                  | (ARRAY_SIZE) | Mode | Cnt | Score ± Error  | Units |
|--------------------------------------------|--------------|------|-----|----------------|-------|
| BenchmarkInit.initArrayInt                 | 1000000      | avgt | 20  | 0,426 ± 0,082  | ms/op |
| BenchmarkInit.initArrayInteger             | 1000000      | avgt | 20  | 0,403 ± 0,050  | ms/op |
| BenchmarkInit.initArrayIntegerActual       | 1000000      | avgt | 20  | 0,326 ± 0,038  | ms/op |
| BenchmarkInit.initArrayIntegerPrimitive    | 1000000      | avgt | 20  | 0,275 ± 0,009  | ms/op |
| BenchmarkInit.initArrayIntegerValue        | 1000000      | avgt | 20  | 0,310 ± 0,033  | ms/op |
| BenchmarkInit.initArrayListInteger         | 1000000      | avgt | 20  | 0,306 ± 0,034  | ms/op |
| BenchmarkInit.initArrayListIntegerActual   | 1000000      | avgt | 20  | 0,301 ± 0,017  | ms/op |
| BenchmarkInit.initArrayListIntegerValue    | 1000000      | avgt | 20  | 0,295 ± 0,017  | ms/op |
| BenchmarkRead.readArrayInt                 | 1000000      | avgt | 20  | 0,464 ± 0,076  | ms/op |
| BenchmarkRead.readArrayInteger             | 1000000      | avgt | 20  | 1,749 ± 0,206  | ms/op |
| BenchmarkRead.readArrayIntegerActual       | 1000000      | avgt | 20  | 1,741 ± 0,356  | ms/op |
| BenchmarkRead.readArrayIntegerPrimitive    | 1000000      | avgt | 20  | 0,467 ± 0,087  | ms/op |
| BenchmarkRead.readArrayIntegerValue        | 1000000      | avgt | 20  | 1,662 ± 0,097  | ms/op |
| BenchmarkRead.readArrayListInteger         | 1000000      | avgt | 20  | 1,806 ± 0,216  | ms/op |
| BenchmarkRead.readArrayListIntegerActual   | 1000000      | avgt | 20  | 1,764 ± 0,204  | ms/op |
| BenchmarkRead.readArrayListIntegerValue    | 1000000      | avgt | 20  | 1,803 ± 0,237  | ms/op |
| BenchmarkWirte.writeArrayInt               | 1000000      | avgt | 20  | 0,314 ± 0,005  | ms/op |
| BenchmarkWirte.writeArrayInteger           | 1000000      | avgt | 20  | 15,594 ± 7,434 | ms/op |
| BenchmarkWirte.writeArrayIntegerActual     | 1000000      | avgt | 20  | 14,933 ± 7,214 | ms/op |
| BenchmarkWirte.writeArrayIntegerPrimitive  | 1000000      | avgt | 20  | 0,315 ± 0,006  | ms/op |
| BenchmarkWirte.writeArrayIntegerValue      | 1000000      | avgt | 20  | 14,971 ± 7,797 | ms/op |
| BenchmarkWirte.writeArrayListInteger       | 1000000      | avgt | 20  | 45,319 ± 5,324 | ms/op |
| BenchmarkWirte.writeArrayListIntegerActual | 1000000      | avgt | 20  | 47,484 ± 7,583 | ms/op |
| BenchmarkWirte.writeArrayListIntegerValue  | 1000000      | avgt | 20  | 47,330 ± 7,831 | ms/op |