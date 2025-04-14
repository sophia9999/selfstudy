#include <stdio.h>

int main() {
    int a = 42;
    int *p = &a;
    printf("a: %d, *p: %d, p: %p\n", a, *p, p);
    return 0;
}