<template>
    <div>
        <el-row>
            <el-col :span="12">
                <cos-upload folder="/test/"
                            @success="asuccess">
                </cos-upload>
            </el-col>
            <el-col :span="12">
                <cos-upload folder="/test/"
                            @success="bsuccess">
                </cos-upload>
            </el-col>
        </el-row>
        <el-row>
            <el-rate
                    v-model="result"
                    :allow-half="true"
                    :colors="['#99A9BF', '#F7BA2A', '#FF9900']">
            </el-rate>
            <span>{{result * 20}}</span>
        </el-row>
    </div>
</template>

<script>
    import cosUpload from './CosUpload.vue'

    export default {
        components: {
            'cos-upload': cosUpload
        },
        data() {
            return {
                folder: '/test/',
                personAUrl: '',
                personBUrl: '',
                result: 0
            }
        },
        watch: {
            personAUrl(newValue, oldValue) {
                if (this.personBUrl !== '') {
                    this.axios.post('http://127.0.0.1:8080/faceCompare/compare', {
                        urlA: this.personAUrl, urlB: this.personBUrl
                    }).then((success) => {
                        if (success.data.code === 0) {
                            this.result = success.data.data.similarity / 20.0
                            console.log(this.result);
                        } else {
                            alert(success.data.message);
                        }
                    }).catch(error => {
                        console.log(error);
                        alert(error.message)
                    });
                }
            },
            personBUrl(newValue, oldValue) {
                if (this.personAUrl !== '') {
                    this.axios.post('http://127.0.0.1:8080/faceCompare/compare', {
                        urlA: this.personAUrl, urlB: this.personBUrl
                    }).then((success) => {
                        if (success.data.code === 0) {
                            this.result = success.data.data.similarity / 20.0
                            console.log(this.result);
                        } else {
                            alert(success.message);
                        }
                    }).catch(error => {
                        console.log(error);
                        alert(error.message);
                    });
                }
            }
        },
        methods: {
            asuccess(url) {
                this.personAUrl = url;
            },
            bsuccess(url) {
                this.personBUrl = url;
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