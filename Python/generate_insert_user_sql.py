## generate 1millions records(name, age) to data.csv, and use data.csv to import data;

import csv
import names
import random

with open('data.csv', 'w+', newline='') as file:
    writer = csv.writer(file)

    for n in range(0, 6000):
        writer.writerow([names.get_first_name(), random.randrange(0, 101, 2)])

