import pandas as pd
import matplotlib.pyplot as plt


def main():
    """
    Do some analysis on the data from the python and java simulations.
    """
    py_out = pd.read_csv("../resources/CSVs/pyout.csv")
    jav_out = pd.read_csv("../resources/CSVs/javout.csv")

    # Time, Mass, Net Force, Y-Acceleration, Y-velocity, Altitude

    for column in py_out[py_out.columns[1:]]:
        plt.scatter(
            x=py_out["Time"],
            y=py_out[column],
            s=1,
        )
        plt.title(f"Python{column} vs Time")
        plt.show()

    for column in jav_out[jav_out.columns[1:]]:
        plt.scatter(
            x=jav_out["Time"],
            y=jav_out[column],
            s=1,
        )
        plt.title(f"Java{column} vs Time")
        plt.show()


if __name__ == "__main__":
    main()
