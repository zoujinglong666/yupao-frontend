const cronJob = require("cron").CronJob;
const {getCommentList} = require('./api')
//true代表直接启动
//'Asia/Chongqing' 时区的填写，如果要国内的时区将 America/Los_Angeles 改为 Asia/Chongqing
// 不立即执行任务，人工启动，人工停止
let job;
const createJob = (socket) => {

    if (job) {
        return
    }
    job = new cronJob('0/10 * * * * * ', async function () {

            const data = await getCommentList(1)
            alert(data)
            socket.broadcast.emit('sendData', data);
            console.log(data)
            //your job code here
        }, null,
        false,
        'Asia/Chongqing'
    );

    job.start();
}

module.exports = {
    createJob
}


