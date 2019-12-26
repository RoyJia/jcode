from babel import dates
from datetime import datetime

today = datetime.today()

test_date = datetime(today.year, today.month, 1)

pattern = 'EEE, d MMM'

locale = 'en_AU'

sample = dates.format_date(test_date, format=pattern, locale=locale)

print(sample)