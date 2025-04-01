import asyncio
import time

# sleep을 통해 서로 cpu를 양보하며 실행하는 경우
async def yield_task(name, delay):
    for i in range(3):
        print(f"{name}: step {i} at {time.strftime('%X')}")
        await asyncio.sleep(delay)
    print(f"{name} 완료 at {time.strftime('%X')}")

# 양보하지 않고 CPU를 점유하는 경우
async def task(name, delay):
    for i in range(3):
        print(f"{name}: step {i} at {time.strftime('%X')}")
    print(f"{name} 완료 at {time.strftime('%X')}")

async def main():
    await asyncio.gather(
        yield_task("yield_task1", 1),
        yield_task("yield_task2", 1)
    )

    await asyncio.gather(
        task("task1", 1),
        task("task2", 1)
    )

asyncio.run(main())
