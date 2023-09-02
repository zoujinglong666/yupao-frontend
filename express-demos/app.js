const express = require('express')
const bodyParser=require('body-parser')
const app = express()
app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())
// app.get('/',(request,response)=>{
// 	response.send('hello');
// })

//post请求需要中间件
app.post('/',(req,res)=>{
	console.log('res :>> ', res.body);
	res.send({
		msg:"请求成功",
		code:200
	})
})

app.listen(3000,()=>{
	console.log(`Server running at http://localhost:3000/`)
})