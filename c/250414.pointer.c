#include <stdio.h>

int main() {
    int a = 10;
    int* p = &a;

    printf("a의 값: %d\n", a);
    printf("a의 주소: %p\n", &a);
    printf("p가 가리키는 값: %d\n", *p);
    printf("p의 값(= a의 주소): %p\n", p);
    printf("p의 주소: %p\n", &p);

    return 0;
}