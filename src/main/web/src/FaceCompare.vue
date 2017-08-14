<template>
    <div id="face-compare">
        <el-row>
            <el-col :span="12">
                <el-upload
                        ref="personA"
                        action=""
                        :before-upload="uploadA">
                    <img v-if="personAUrl" :src="personAUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </el-col>
            <el-col :span="12">
                <el-upload
                        ref="personB"
                        action=""
                        :before-upload="uploadB">
                    <img v-if="personBUrl" :src="personBUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </el-col>
        </el-row>
        <el-row>
            <el-rate
                    v-model="result"
                    :allow-half="true"
                    :colors="['#99A9BF', '#F7BA2A', '#FF9900']">
            </el-rate>
            <span>{{result*20}}</span>
        </el-row>
    </div>
</template>

<script>
    import cos from './cos'
    import axios from 'axios'
    import ElRow from "element-ui/packages/row/src/row";
    import ElCol from "element-ui/packages/col/src/col";

    export default {
        components: {
            ElCol,
            ElRow
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
                    axios.post('http://127.0.0.1:8080/faceCompare/compare', {
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
                    axios.post('http://127.0.0.1:8080/faceCompare/compare', {
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
            uploadA(file) {
                cos.uploadFile(success => {
                        if (success.code === 0) {
                            this.personAUrl = success.data.source_url
                        } else {
                            alert(success.message)
                        }
                    },
                    error => alert(error.message),
                    process => console.log(process),
                    cos.bucket, this.folder + file.name, file, 0);
                return false;
            },
            uploadB(file) {
                cos.uploadFile(success => {
                        if (success.code === 0) {
                            this.personBUrl = success.data.source_url
                        } else {
                            alert(success.message)
                        }
                    },
                    error => alert(error.message),
                    process => console.log(process),
                    cos.bucket, this.folder + file.name, file, 0);
                return false;
            },
        },

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