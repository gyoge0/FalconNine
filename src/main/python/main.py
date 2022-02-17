import math
from decimal import Decimal

PER_SECOND = Decimal(2)

MASS_EARTH = Decimal(5.978) * Decimal(10 ** 24)
BIG_G = Decimal(6.67) * Decimal(10 ** -11)
RAD_EARTH = Decimal(6.38) * Decimal(10 ** 6)
FUEL_BURN_RATE = Decimal(398900 / 162)
THRUST = Decimal(6806000)
START_MASS = Decimal(541300)
DRAG_COEFFICIENT = Decimal("0.295")
AREA = Decimal(36)


def get_dens(alt2: Decimal) -> Decimal:
    return Decimal(1.2787 * (math.e ** (-0.000114616 * float(alt2))))


def main():
    """
    Run the falcon nine simulation
    """
    vel = 0
    alt = 0

    with open("../resources/CSVs/pyout.csv", "w+") as out:
        out.write(
            "Time, Mass, Net Force, Y-Acceleration, Y-velocity, Altitude\n")
        for i in range(int(163 * PER_SECOND)):
            sec = i / PER_SECOND
            mass = START_MASS - (FUEL_BURN_RATE * sec)
            f_g = (mass * BIG_G * MASS_EARTH) / ((RAD_EARTH + alt) ** 2)
            f_d = (Decimal(0.5) * DRAG_COEFFICIENT * AREA * get_dens(
                Decimal(alt))) * (
                      vel ** 2
                  )

            net = THRUST - f_g - f_d

            accel = net / mass
            vel += accel / PER_SECOND
            alt += vel / PER_SECOND

            out.write(
                f"{i / PER_SECOND}, {mass}, {net}, {vel}, {accel}, {alt}\n")


if __name__ == "__main__":
    main()
