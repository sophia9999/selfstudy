import multiprocessing
import time

def cpu_bound_task(n):
    count = 0
    for i in range(10 ** 8):
        count += i
    return count

if __name__ == "__main__":

    print(f"start at {time.strftime('%X')}")
    start = time.time()

    processes = []
    # 비교를 위해 변수처리
    process_count = 2
    #process_count = multiprocessing.cpu_count()
    print(f"process_count : {process_count}")
    for _ in range(process_count):
        p = multiprocessing.Process(target=cpu_bound_task, args=(1,))
        processes.append(p)
        p.start()

    for p in processes:
        p.join()

    print(f"end at {time.strftime('%X')} 소요 시간: {time.time() - start:.2f}초")

