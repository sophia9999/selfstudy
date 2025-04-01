import asyncio
import time

async def cpu_heavy(name, delay):
    print(f"{name}: start at {time.strftime('%X')}")
    for i in range(10**8):
        pass
    print(f"{name}: end at {time.strftime('%X')}")

async def io_task(name, delay):
    print(f"{name} started at {time.strftime('%X')}")
    await asyncio.sleep(delay)
    print(f"{name} finished at {time.strftime('%X')}")

async def main():
    await asyncio.gather(
        cpu_heavy("cpu_heavy_task", 1),
        io_task("io_task", 1)
    )

asyncio.run(main())
