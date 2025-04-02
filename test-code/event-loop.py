import asyncio
import time

# sleep을 통해 서로 cpu를 양보하며 실행하는 경우
async def yield_task(name):
    for i in range(3):
        print(f"{name}: step {i} at {time.strftime('%X')}")
        await asyncio.sleep(0) # 여기지점에서 양보
    print(f"{name} 완료 at {time.strftime('%X')}")

# 양보하지 않고 CPU를 점유하는 경우
async def task(name):
    for i in range(3):
        print(f"{name}: step {i} at {time.strftime('%X')}")
    print(f"{name} 완료 at {time.strftime('%X')}")

async def main():
    await asyncio.gather(
        yield_task("yield_task1"),
        yield_task("yield_task2")
    )

    await asyncio.gather(
        task("task1"),
        task("task2")
    )

asyncio.run(main())
