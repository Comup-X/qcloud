import axios from 'axios'
import CosCloud from 'cos-js-sdk-v4'

//初始化逻辑
//特别注意: JS-SDK使用之前请先到console.qcloud.com/cos 对相应的Bucket进行跨域设置
var cos = new CosCloud({
    appid: 1253953328,// APPID 必填参数
    bucket: 'test',//bucketName 必填参数
    region: 'gz',//地域信息 必填参数 华南地区填gz 华东填sh 华北填tj
    getAppSign: function (callback) {//获取签名 必填参数
        axios.get('http://127.0.0.1:8080/sign/sign').then(function (response) {
            debugger;
            console.log('sign is:' + response.data);
            callback(response.data);
        }).catch(function (error) {
            console.log(error);
        });
    },
    getAppSignOnce: function (callback) {
        debugger;
        axios.get('http://127.0.0.1:8080/sign/onceSign').then(function (response) {
            console.log('onceSign is:' + response.data);
            callback(response.data);
        }).catch(function (error) {
            console.log(error);
        });
    }
});

export default cos;