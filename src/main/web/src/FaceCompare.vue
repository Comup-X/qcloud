<template>
    <div id="face-compare">
        <el-row>
            <el-col :span="12">
                <el-upload
                        ref="personA"
                        class="upload-demo"
                        action=""
                        :before-upload="upload">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过20M</div>
                </el-upload>
            </el-col>
            <el-col :span="12">
                <el-upload
                        ref="personB"
                        class="upload-demo"
                        action=""
                        :before-upload="upload">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过20M</div>
                </el-upload>
            </el-col>
        </el-row>

    </div>
</template>

<script>
    import cos from './cos'

    export default {
        data() {
            return {
                folder: '/test/'
            }
        },
        methods: {
            upload(file) {
                console.log(cos);
                cos.uploadFile(
                    function (success) {
                        console.log(success);
                    },
                    function (error) {
                        console.log(error);
                    }, function (process) {
                        console.log(process);
                    }, cos.bucket
                    , this.folder + file.name, file, 0);
                return false;
            }
        }
    }
</script>

<style>

</style>