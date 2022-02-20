# Falcon Nine

---
A simulation of a Falcon 9 rocket.

## Running (No Kotlin/Maven)

---
1. Clone the repository:

```
git clone -b submission https://github.com/gyoge0/FalconNine.git
```

2. cd to `submission` folder

```
cd FalconNine/submission
```

3. Rename .java.txt files to .java
    - Windows (PowerShell)
   ```
   Dir *.java.txt | rename-item -newname { [io.path]::ChangeExtension($_.name, ".java") }
   ```
    - Windows (Command Prompt)
   ```
   ren *.java.txt *.java
   ```
    - Bash
   ```
   for f in *.java.txt; do mv -- "$f" "${f%.java.txt.java}.java"; done
   ```
4. Compile

```
javac *.java
```

5. Run
   - FalconNine animation
   ```
   java FalconNine
   ```
   - FalconNine tester/simulation
   ```
   java FalconNieTester
   ```
   - FalconHeavy tester/simulation
   ```
   java FalconHeavyTester
   ```
