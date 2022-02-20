# Falcon Nine

---
A simulation of a Falcon 9 rocket written with Java, Kotlin, and Python.

## Running (No Kotlin/Maven)

---
1. Clone the repository:

```bash
git clone -b submission https://github.com/gyoge0/FalconNine.git
```

2. cd to `submission` folder

```bash
cd FalconNine/submission
```

3. Rename .java.txt files to .java
    - Windows (PowerShell)
   ```ps1
   Dir *.java.txt | rename-item -newname { [io.path]::ChangeExtension($_.name, ".java") }
   ```
    - Windows (Command Prompt)
   ```cmd
   ren *.java.txt *.java
   ```
    - Bash
   ```bash
   for f in *.java.txt; do mv -- "$f" "${f%.java.txt.java}.java"; done
   ```
4. Compile

```bash
javac *.java
```

5. Run
   - FalconNine animation
   ```bash
   java FalconNine
   ```
   - FalconNine tester/simulation
   ```bash
   java FalconNieTester
   ```
   - FalconHeavy tester/simulation
   ```bash
   java FalconHeavyTester
   ```
