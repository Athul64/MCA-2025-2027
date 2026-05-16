// Create Collection
db.createCollection("Employee");
db.createCollection("empDetails");

// Insert Multiple Documents
db.Employee.insertMany([
{empid:1,name:"mohan",dept:"IT",age:25,email:"a@gmail.com",phone:12345,salary:6000,city:"Chennai"},
{empid:2,name:"raju",dept:"HR",age:29,email:"b@gmail.com",phone:22345,salary:7000,city:"Kochi"},
{empid:3,name:"bhuvan",dept:"Sales",age:35,email:"c@gmail.com",phone:32345,salary:4000,city:"Trichy"},
{empid:4,name:"ramesh",dept:"IT",age:27,email:"d@gmail.com",phone:42345,salary:8000,city:"Madurai"},
{empid:5,name:"suresh",dept:"Admin",age:58,email:"e@gmail.com",phone:52345,salary:9000,city:"Delhi"}
]);

// Retrieve Fields
db.Employee.find({}, {empid:1,name:1,dept:1,phone:1,salary:1,city:1});

// Find name mohan
db.Employee.find({name:"mohan"});

// Salary >=5000
db.Employee.find({salary:{$gte:5000}});

// Name starts with r
db.Employee.find({name:/^r/});

// Employees per department
db.Employee.aggregate([
{$group:{_id:"$dept",count:{$sum:1}}}
]);

// Name not in
db.Employee.find({
name:{$nin:["mohan","raju","bhuvan"]}
});

// Age <30
db.Employee.find(
{age:{$lt:30}},
{name:1,salary:1}
);

// Salary >5000 and age <30
db.Employee.find({
salary:{$gt:5000},
age:{$lt:30}
});

// Sort ascending
db.Employee.find().sort({name:1});

// Delete age >56
db.Employee.deleteMany({age:{$gt:56}});