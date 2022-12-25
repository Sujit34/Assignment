let allStudents = [];
let allCourses = [];

window.onload = function () {

    load();

}

const load = () => {
    loadStudents();
    loadAllCourses();
}



const loadAllCourses = async function () {
    const userId = sessionStorage.getItem('userId');

    let results = await fetch('http://localhost:8080/courses');

    const courses  = await results.json();

    if (courses) {
        allCourses = courses;
    }

    console.log("All courses", allCourses);
    updateDomWithCourses(allCourses);
}

const loadStudents = async function () {

    let results = await fetch('http://localhost:8080/students');


    const studentsResults =  await results.json();

    if (studentsResults && studentsResults.length) {

        allStudents = studentsResults;
    }
    updateDomWithStudents(allStudents);


}

const addNewCourse = async () => {

    let results = await fetch('http://localhost:8080/courses/', {
        method: 'POST',
       
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: document.getElementById('id').value,
            name: document.getElementById('name').value,
            code: document.getElementById('code').value
        })
    });

    if (results.status === 200 || results.status === 201) {
        load();
    }
}

const addNewStudents = async () => {

    let results = await fetch('http://localhost:8080/students/', {
        method: 'POST',
       
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: document.getElementById('id').value,
            firstname: document.getElementById('firstname').value,
            lastname: document.getElementById('lastname').value,
            email: document.getElementById('email').value,
            major: document.getElementById('major').value,
            coursetaken: document.getElementById('coursetaken').value,
        })
    });

    if (results.status === 200 || results.status === 201) {
        load();
    }
}


const updateDomWithCourses = function (courses) {

    if (courses && courses.length) {
        let tableData = '<th>Id</th><th>Name</th><th>Code</th>';
        courses.forEach((course) => {
            const { id, name, code } = course;
            console.log("The values", id, name, code);
            tableData += `<tr id="cart-item-${id}"><td>${id}</td><td>${name}</td><td>${code}</td></tr>`;
        });
       
        document.getElementById("items-table").innerHTML = tableData;
    } 

}


const updateDomWithStudents = function (students) {
    if (students && students.length) {
        let tableData = '<th>Id</th><th>First Name</th><th>LastName</th><th>Email</th><th>Major</th>'
        students.forEach((student) => {
            const { id, firstName, lastName, major, email } = student;
            tableData += `<tr><td>${id}</td><td>${firstName}</td><td>${lastName}</td><td>${email}</td><td>${major}</td></tr>`
        });
       
        document.getElementById("products-table").innerHTML = tableData;
    } else {
        document.getElementById("product-list").style.display = 'none';
    }

}
