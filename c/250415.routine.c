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

    return 0;
}