function dayFibonaci(number: number): number {
    if (number < 0) {
        return -1;
    }
    if (number == 0 || number == 1) {
        return number;
    }
    return dayFibonaci(number-1) + dayFibonaci(number-2);
}

console.log("Dãy fibonacci gồm 10 chữ số")
for (let i=0; i<10; i++) {
    console.log(dayFibonaci(i))
}

let sum: number = 0;
console.log("Tổng của dãy fibonacci gồm 10 chữ số")
for (let i=0; i<10; i++) {
    sum += dayFibonaci(i);
}
console.log(sum)

