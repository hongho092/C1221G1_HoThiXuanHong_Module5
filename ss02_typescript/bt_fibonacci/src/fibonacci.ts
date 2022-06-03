function day_fibonaci(number: number): number {
    if (number < 0) {
        return -1;
    }
    if (number == 0 || number == 1) {
        return number;
    }
    return day_fibonaci(number-1) + day_fibonaci(number-2);
}

console.log("Dãy fibonacci gồm 10 chữ số")
for (let i=0; i<10; i++) {
    console.log(day_fibonaci(i))
}


