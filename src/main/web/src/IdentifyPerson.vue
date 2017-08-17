<template>
    <div>
        <cos-upload folder="/test/"
                    @success="success">
        </cos-upload>
        <p>点击图标上传图片</p>
        <el-button @click="identify">检索</el-button>
        <span>{{result}}</span>
    </div>
</template>

<script>

export default {
    data(){
        return {
            faceUrl:'',
            result:''
        }
    },

    methods:{
        success(url){
            this.faceUrl=url;
        },
        identify(){
            if(this.faceUrl===''){
                alert('请先上传');
                return;
            }
            this.axios.get('/person/identifyPerson',{
                params: {
                    faceUrl: this.faceUrl
                }
            }).then(success=>{
                this.result=success.data;
            }).catch(error=>{
                console.log(error);
                alert("检索失败");
            })
        }
    }
}
</script>

<style>

</style>