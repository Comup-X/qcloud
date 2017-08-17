<template>
    <div>
        <el-row>
            <el-col :span="12">
                <cos-upload folder="/test/"
                            @success="asuccess">
                </cos-upload>
                <span>点击图标上传图片</span>
            </el-col>
            <el-col :span="12">
                <cos-upload folder="/test/"
                            @success="bsuccess">
                </cos-upload>
                <span>点击图标上传图片</span>
            </el-col>
        </el-row>
        <el-row>
            <span>对比结果</span>
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

    export default {

        data() {
            return {
                personAUrl: '',
                personBUrl: '',
                result: 0
            }
        },
        watch: {
            personAUrl(newValue, oldValue) {
                if (this.personBUrl !== '') {
                    debugger;
                    this.axios.post('/faceCompare/compare', {
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
                    debugger;
                    this.axios.post('/faceCompare/compare', {
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
                debugger;
                this.personAUrl = url;
            },
            bsuccess(url) {
                debugger;
                this.personBUrl = url;
            }
        }
    }
</script>

<style>

</style>