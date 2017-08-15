<template>
    <el-upload
            action=""
            :http-request="upload"
            :show-file-list="false">
        <img v-if="url" :src="url" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
</template>

<script>

    import ElUpload from 'element-ui'
    import uuid from 'uuid'

    export default {

        extends: ElUpload,

        props: {
            folder: ''
        },

        watch: {
//            fileList(newValue, oldValue) {
//                debugger;
//                console.log('newValue is:' + newValue);
//            }
        },

        data() {
            return {
                url: '',
            }
        },

        methods: {
            upload(request) {
                this.cos.uploadFile(success => {
                        if (success.code === 0) {
                            this.axios.post('http://127.0.0.1:8080/face/add', {
                                faceId: uuid.v1(), faceUrl: success.data.source_url
                            }).then(success => {
                                if (!success.data) {
                                    alert('上传失败');
                                } else {
                                    this.url = success.data.source_url;
                                    this.$emit('success', this.url, this);
                                }
                            }).catch(error => {
                                alert(error)
                            });
                        } else {
                            alert(success.message)
                        }
                    },
                    error => alert(error.message),
                    process => console.log(process),
                    this.cos.bucket, this.folder + request.file.name, request.file, 0);
            }
        }
    }
</script>

<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #20a0ff;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>