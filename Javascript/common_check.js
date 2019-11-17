
let data = require("./resources/data.json");

console.log("------------------------------------");

let job_summaries = data.job_summaries;

let aaa = job_summaries.map(item => item.lob);

console.log(new Set(aaa));