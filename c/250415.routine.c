#include <stdio.h>

void printArray(int* arr, int size) {
    for(int i = 0 ; i < size; i++) {
        printf("arr[%d] = %d, 주소 = %p\n", i, arr[i], &arr[i]);
    }
}

int main() {
    int nums[3] = {10, 20, 30};
    printf("nums = %p &nums[0] = %p\n", nums, &nums[0]);

    printArray(nums, 3);

    // 종료코드 0 : 정상종료
    // 1, -1 : 비정상 종료
    // 명시적으로 쓰는 것이 의도를 분명히 할 수 있어서 쓰는 습관을 가질 것
    // 프로그램 끝났다고 OS에 알려줌
    return 0;
}