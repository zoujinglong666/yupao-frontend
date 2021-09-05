const express = require('express')
const app = express()
app.get('/server',(request,response)=>{
	request.setHeader('Access-Control-Allow-Origin','*');
	response.send('hello');
})
app.listen(3000,()=>{
	console.log(`Server running at http://localhost:3000/`)
})