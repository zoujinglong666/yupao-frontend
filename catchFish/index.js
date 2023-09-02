const express = require('express')
const api = require('./api.js')
const app = express()
const {createJob} = require('./cron.js')

app.get('/', (req, res) => {

    res.sendFile(__dirname + '/index.html');
    console.log(__dirname)

});
app.get('/get_comment_list/:pageSize', async (req, res) => {
    res.send('Hello World!')
})
// app.listen(port, () => {
//     console.log(`Example app listening on port ${port}`)
// })
const port = 3001;

const http = require('http');
const server = http.createServer(app);
const {Server} = require("socket.io");
const io = new Server(server, {
    cors: {
        origin: 'http:localhost:3000',
        credentials: true
    }

});
io.on('connection', (socket) => {
    createJob(socket)

    console.log('a user connected');
});

server.listen(port, () => {
    console.log(port);
});

