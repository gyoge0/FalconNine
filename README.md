# Falcon Nine

---
A simulation of a Falcon 9 rocket written with Java, Kotlin, and Python.

## Documentation

---
Documentation via JavaDoc is available
at [https://gyoge0.github.io/FalconNine/javadoc](https://gyoge0.github.io/FalconNine/javadoc).
Documentation via Dokka is available
at [https://gyoge0.github.io/FalconNine/dokka](https://gyoge0.github.io/FalconNine/dokka).

## Running (Java w/Maven)

---

1. Clone the repository

```bash
git clone -b master https://github.com/gyoge0/FalconNine.git
```

2. cd in

```bash
cd FalconNine
```

3. Run
    - FalconNine animation
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.gyoge.itcsgraphics.animations.FalconNine"
   ```
    - FalconNine tester/simulation
   ```
   mvn clean compile exec:java -Dexec.mainClass="com.gyoge.itcsgraphics.testers.FalconNineTester"
   ```
    - FalconHeavy tester/simulation
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.gyoge.itcsgraphics.testers.FalconHeavyTester"
   ```

## Analysis (Python3 and Java w/Maven)

---

1. Create CSVs directory (ignore any existing directory errors)

```bash
mkdir src/main/resources/CSVs
```

2. Run FalconNine tester, redirecting output

```bash
mvn clean compile exec:java -Dexec.mainClass="com.gyoge.itcsgraphics.testers.FalconNineTester" -l src/main/resources/CSVs/javout.csv -q
```

3. Run Python3 simulation
    - Windows
   ```bash
   py src/main/python/main.py
   ```
    - Bash
   ```bash
   python3 src/main/python/main.py
   ```
4. Run analysis
    - Windows
   ```bash
   py src/main/python/analysis.py
   ```
    - Bash
   ```bash
   python3 src/main/python/analysis.py
   ```
