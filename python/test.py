import datetime

now = datetime.datetime.now()

then =  now - datetime.timedelta(days=90)

print(f"now: {now.timestamp()} | then: {then.timestamp()}")

