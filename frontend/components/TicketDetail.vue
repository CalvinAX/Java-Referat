<template>
    <div class="cmdb-key-wrapper">
        <header></header>
        <main>
            <form @submit.prevent="handleSubmit()">
                <div class="object-view">
                    <NuxtLink :to="{ path: '/tickets' }">
                        <svg width="24" height="24" viewBox="0 0 24 24" role="presentation">
                            <circle fill="currentColor" cx="12" cy="12" r="10"></circle>
                            <path
                                d="M16 10.995h-5.586l1.272-1.279a1.01 1.01 0 000-1.421.996.996 0 00-1.415 0l-2.978 2.994a1.01 1.01 0 000 1.423l2.978 2.993a.999.999 0 001.415 0 1.01 1.01 0 000-1.421l-1.272-1.279H16c.552 0 1-.45 1-1.005 0-.555-.448-1.005-1-1.005"
                                fill="inherit"></path>
                        </svg>
                        Zurück zur Listenansicht
                    </NuxtLink>
                    <div class="id">JR-{{ result.id }}</div>
                    <div class="details-view-wrapper">
                        <TicketDetailView v-if="!edit" :result="result" />
                        <TicketDetailUpdate v-else :result="result" :submit="submit" @updated="handleUpdate" />
                        <!-- updated = true -->
                    </div>
                    <div class="edit-save">
                        <span v-if="!edit" @click="edit = true; submit = false; updated = false">Edit</span>
                        <span v-if="edit"><button type="submit" @click="handleSubmit()">Save</button></span>
                    </div>
                    <div class="delete">
                        <span @click="handleDelete()">Delete</span>
                    </div>
                </div>
            </form>
        </main>
        <footer></footer>
    </div>
</template>
  
<script setup lang="ts">
// const route = useRoute()
// const key = ref(route.params.key)

const props = defineProps(['result'])
const result = ref(props.result);

const edit = ref(false)
const submit = ref(false)

const updated = ref(false)

const handleUpdate = (updateData: any) => {
    // updatedValue.value = updateData
    updated.value = true
    console.log('data: ', updateData)
    let updatedValues = {
        id: updateData.id,
        title: updateData.title,
        description: updateData.description,
        creator: updateData.creato.id,
        closedBy: updateData.closedBy.id,
        assignee: updateData.assignee.id,
        status: updateData.status,
        priority: updateData.priority,
        createdAt: updateData.createdAt,
        deadline: updateData.deadline,
    }

    result.value = updateData
}

watch(updated, async () => {
    if (updated) {
        edit.value = false
        try {
            const response = await fetch(`/api/tickets/${result.value.id}`)
            if (!response.ok) {
                throw new Error('No available data');
            }
            const data = await response.json();

            result.value = data;
        } catch (error: any) {
            console.error('Error fetching data:', error.message);
        }
    }
})

const handleSubmit = () => {
    submit.value = true;
};

const router = useRouter()
const handleDelete = async () => {
    try {
        const response = await fetch(`/api/tickets/delete/${result.value.id}`)
        if (!response.ok) {
            throw new Error('No available data');
        }
        const data = await response.json();

        result.value = data;
    } catch (error: any) {
        console.error('Error fetching data:', error.message);
    }
    router.push("/tickets")
};


// if (!submit) {
//     try {
//         const response = await fetch(`/api/tickets/${result.id}`)
//         if (!response.ok) {
//             throw new Error('No available data');
//         }
//         const data = await response.json();

//         result.value = data;
//     } catch (error: any) {
//         console.error('Error fetching data:', error.message);
//     }
// }

</script>
  
<style lang="scss">
@import "@/assets/scss/variables.scss";

.cmdb-key-wrapper {
    padding-left: 20px;
    padding-top: 30px;

    main {
        &>*:not(.subnav) {
            margin-left: 8px;
        }

        &>h1 {
            margin-bottom: 40px;
        }

        .subnav {
            display: flex;
            // gap: 15px;
            position: relative;
            margin-bottom: 20px;

            &::before {
                // content: '';
                // position: absolute;
                // width: 100%;
                // height: 100%;
                // border-bottom: 2px solid #A6C5E229;

                content: "";
                border-radius: 2px;
                bottom: 0px;
                margin: 0px;
                position: absolute;
                width: inherit;
                left: 8px;
                right: 8px;
                height: 2px;
                background-color: #A6C5E229;
            }

            div {
                font-size: 14px;
                line-height: 25.2px;
                font-weight: 500;
                padding: 4px 8px;
                cursor: pointer;
                position: relative;
                transition: all 0.1s ease-out 0s, box-shadow 0.15s cubic-bezier(0.47, 0.03, 0.49, 1.38) 0s;

                &.subnav-active {
                    color: #579DFF;

                    &:after {
                        // border-bottom: 2px solid #A6C5E229;
                        content: "";
                        border-radius: 2px;
                        bottom: 0px;
                        margin: 0px;
                        position: absolute;
                        left: 8px;
                        right: 8px;
                        height: 0px;
                        border-bottom: 2px solid #579DFF;
                    }
                }

                &:not(.subnav-active):hover::after {
                    // border-bottom: 2px solid #A6C5E229;
                    content: "";
                    border-radius: 2px;
                    bottom: 0px;
                    margin: 0px;
                    position: absolute;
                    left: 8px;
                    right: 8px;
                    height: 0px;
                    border-bottom: 2px solid #A6C5E229;
                }
            }
        }

        .object-view>a {
            text-decoration: none;
            color: inherit;
            font-size: 14px;
            line-height: 32px;
            font-weight: 500;
            // padding: 5px;
            // padding: 0 10px;

            transition: background 0.1s ease-out 0s, box-shadow 0.15s cubic-bezier(0.47, 0.03, 0.49, 1.38) 0s;

            display: flex;
            align-items: center;
            gap: 5px;

            position: relative;
            width: fit-content;

            &:hover::after {
                content: '';
                width: 100%;
                height: 100%;
                // transform: translateX(-10px);
                padding: 0 10px;
                border-radius: 3px;
                left: -10px;
                position: absolute;
                background: #282d33;
                z-index: -1;
            }
        }

        .object-view {
            .id {
                margin-top: 50px;
                margin-left: 30px;
            }

            .details-view-wrapper {
                margin-left: 30px;
            }

            .activity-view {
                margin-left: 8px;
            }

            .edit-save {
                margin-top: 50px;
                margin-left: 30px;

                span {
                    color: rgb(32, 167, 212);
                    cursor: pointer;

                    &:hover {
                        text-decoration: underline;
                    }

                    button {
                        margin: 0;
                        padding: 0;
                        border: none;
                        background: none;
                        font: inherit;
                        color: inherit;
                        cursor: pointer;

                        &:hover {
                            text-decoration: underline;
                        }
                    }
                }
            }

            .delete {
                margin-top: 25px;
                margin-left: 30px;

                span {
                    color: #FF5757;
                    cursor: pointer;

                    &:hover {
                        text-decoration: underline;
                    }

                    button {
                        margin: 0;
                        padding: 0;
                        border: none;
                        background: none;
                        font: inherit;
                        color: inherit;
                        cursor: pointer;

                        &:hover {
                            text-decoration: underline;
                        }
                    }
                }
            }
        }
    }
}
</style>
  



<!-- <template>
    <div class="ticket-detail-comp">
        <h1>{{ result.title }}</h1>
        <span>{{ result.description }}</span>
        <span>{{ result.priority }}</span>
        <span>{{ result.status }}</span>
    </div>
</template>

<script setup lang="ts">
const props = defineProps(['result'])
const result = ref(props.result);
</script>

<style scoped>
.ticket-detail-comp {
    padding: 15px;
    display: flex;
    flex-direction: column;

}
</style> -->