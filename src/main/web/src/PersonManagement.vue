<template>
    <div>
        <el-table
                ref="singleTable"
                :data="tableData"
                highlight-current-row
                @current-change="handleCurrentChange"
                style="width: 100%">
            <el-table-column
                    type="index"
                    width="50">
            </el-table-column>
            <el-table-column
                    property="name"
                    label="姓名"
                    width="120">
            </el-table-column>
        </el-table>
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
    </div>
</template>

<script>
    export default {
        name: 'PersonManagement',

        data() {
            return {
                faces: [{}],
                tableData: [{
                    name: '王小虎',
                    faces: [1]
                }, {
                    name: '王小虎',
                    faces: [2]
                }, {
                    name: '王小虎',
                    faces: [3]
                }, {
                    name: '王小虎',
                    faces: [4]
                }],
                currentRow: null
            }
        },

        methods: {
            handleCurrentChange(val) {
                this.faces = val.faces;
                this.currentRow = val;
            }
        },

        created() {
            this.axios.get('http://127.0.0.1:8080/person')
                .then(success => {
                    this.tableData = success.data;
                })
                .catch(error => {
                    alert(error)
                });
        }
    }
</script>