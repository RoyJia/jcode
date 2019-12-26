
let data = require("./resources/data.json");

console.log("------------------------------------");

let job_summaries = data.job_summaries;

let aaa = job_summaries.map(item => item.lob);

console.log(new Set(aaa));

let common_list = ["Hello", "javascript", "world"];
console.log(common_list.includes("Hello"));

const empty_str = null;

if (!empty_str) console.log("adfsadfasdfasdfasdfadfadfafa");