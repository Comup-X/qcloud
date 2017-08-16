<template>
    <div>
        <el-input v-model="createRequest.name"></el-input>
        <cos-upload folder="/test/"
                    @success="success">
        </cos-upload>
        <!--<el-upload-->
        <!--action="https://jsonplaceholder.typicode.com/posts/"-->
        <!--list-type="picture-card"-->
        <!--fileList="faces"-->
        <!--:on-preview="handlePictureCardPreview"-->
        <!--:on-remove="handleRemove">-->
        <!--<i class="el-icon-plus"></i>-->
        <!--</el-upload>-->
        <!--<el-dialog v-model="dialogVisible" size="tiny">-->
        <!--<img width="100%" :src="dialogImageUrl" alt="">-->
        <!--</el-dialog>-->
        <el-button @click="create">创建</el-button>
    </div>
</template>

<script>

    export default {

        data() {
            return {
                createRequest: {
                    name: '',
                    faceUrl: ''
                }
            }
        },

        methods: {
            success(url) {
                this.createRequest.faceUrl = url;
            },
            create() {
                if(this.faceUrl===''){
                    alert('请先上传头像');
                    return;
                }
                this.axios.post('/person/create', this.createRequest)
                    .then(success => {
                        console.log(success);
                        alert('创建成功');
                    })
                    .catch(error => {
                        console.log(error);
                        alert("创建失败");
                    });
            }
        }
    }
</script>