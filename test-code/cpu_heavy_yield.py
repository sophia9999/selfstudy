import asyncio
import time

async def cpu_heavy(name):
    print(f"{name}: start at {time.strftime('%X')}")
    for i in range(10**8):
        if i % 2_000_000 == 0 :
            # 이 조건이 해당될 때 await를 걸어 이벤트 루프가 다른 코루틴을 실행할 수 있게 해준다.
            await asyncio.sleep(0)
    print(f"{name}: end at {time.strftime('%X')}")

async def io_task(name):
    print(f"{name} started at {time.strftime('%X')}")
    await asyncio.sleep(1)
    print(f"{name} finished at {time.strftime('%X')}")

async def main():
    await asyncio.gather(
        cpu_heavy("cpu_heavy_task"),
        io_task("io_task")
    )

asyncio.run(main())
