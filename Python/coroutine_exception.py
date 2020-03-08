import asyncio
import time

from random import randint

list = [1, 2, 3, 4, 5, 6, 7, 8]

async def test_method(item):
    time.sleep(3)
    if randint(0, 3) == 0:
        print(f"this is happen in {item}")
        raise Exception("Random generate Exception")


async def async_migrate_data(item):
    try:
        print(f"---------- {item}")
        await test_method(item)
    except Exception as ex:
        raise ex


def migrate_data():
    loop = asyncio.get_event_loop()
    tasks = asyncio.gather(*[async_migrate_data(r) for r in list])
    loop.run_until_complete(tasks)

migrate_data()