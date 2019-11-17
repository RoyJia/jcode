
const TAX_RATE = 0.08;
const PHONE_PRICE = 99.99;

var bank_balance = 303.91;
var total_amount = 0;

function calculateTax(amount) {
    return amount * TAX_RATE;
}

function formatAmount(amount) {
    return '$' + amount.toFixed(2);
}

while (total_amount < bank_balance) {
    total_amount += PHONE_PRICE;
}

total_amount += calculateTax(total_amount);

console.log('Your purchase: ' + formatAmount(total_amount));