function day_fibonaci(number) {
    if (number < 0) {
        return -1;
    }
    if (number == 0 || number == 1) {
        return number;
    }
    return day_fibonaci(number - 1) + day_fibonaci(number - 2);
}
console.log("Dãy fibonacci gồm 10 chữ số");
for (var i = 0; i < 10; i++) {
    console.log(day_fibonaci(i));
}
var sum = 0;
console.log("Tổng của dãy fibonacci gồm 10 chữ số");
for (var i = 0; i < 10; i++) {
    sum += day_fibonaci(i);
}
console.log(sum);
