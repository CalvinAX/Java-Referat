<template>
    <div class="create-wrapper">
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
                    <div class="create-key">Create Ticket</div>
                    <div class="details-view-wrapper">
                        <div class="ticekt-detail-view details-vieww">
                            <div class="detail-value">
                                <div>Title</div>
                                <div class="inpp"><input v-model="title" type="text">
                                </div>
                            </div>
                            <div class="detail-value">
                                <div>Description</div>
                                <div class="inpp"><input v-model="description" type="text">
                                </div>
                            </div>

                            <div class="detail-value">
                                <div>Creator</div>
                                <span>
                                    <select v-model="creator" id="creator" name="creator">
                                        <option v-for="user in userData" :key="user.id" :value="user.id">{{ user.name }}
                                        </option>
                                    </select>
                                </span>
                            </div>
                            <div class="detail-value">
                                <div>Closed by</div>
                                <span>
                                    <select v-model="closedBy" id="closedBy" name="closedBy">
                                        <option v-for="user in userData" :key="user.id" :value="user.id">{{ user.name }}
                                        </option>
                                    </select>
                                </span>
                            </div>
                            <div class="detail-value">
                                <div>Assignee</div>
                                <span>
                                    <select v-model="assignee" id="assignee" name="assignee">
                                        <option v-for="user in userData" :key="user.id" :value="user.id">{{ user.name }}
                                        </option>
                                    </select>
                                </span>
                            </div>

                            <div class="detail-value">
                                <div>Status</div>
                                <span>
                                    <select v-model="status" id="status" name="status">
                                        <option value="Open" class="open">Open</option>
                                        <option value="In Progress" class="inProgress">In Progress</option>
                                        <option value="Closed" class="closed">Closed</option>
                                    </select>
                                </span>
                            </div>
                            <div class="detail-value">
                                <div>Priority</div>
                                <span>
                                    <select v-model="priority" id="priority" name="priority">
                                        <option value="Low" class="Low">Low</option>
                                        <option value="Medium" class="Medium">Medium</option>
                                        <option value="High" class="High">High</option>
                                    </select>
                                </span>
                            </div>
                            <div class="detail-value">
                                <div>Created at</div>
                                <div>
                                    <input v-model="createdAt" type="date" id="createdAt" name="createdAt">
                                </div>
                            </div>
                            <div class="detail-value">
                                <div>deadline</div>
                                <div>
                                    <input v-model="deadline" type="date" id="deadline" name="deadline">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="edit-save">
                        <span><button type="submit">Create</button></span>
                    </div>
                </div>
            </form>
        </main>
        <footer></footer>
    </div>
</template>
  
<script setup lang="ts">

// v-model
const title = ref<string | null>();
const description = ref<string | null>();
const creator = ref<string | number | null>();
const closedBy = ref<String | number | null>();
const assignee = ref<string | number | null>();
const status = ref<string | null>();
const priority = ref<string | null>();
const createdAt = ref<string | null>();
const deadline = ref<string | null>();

const userData = ref()
onMounted(async () => {
    try {
        const response = await fetch('/api/user/getAll')
        if (!response.ok) {
            throw new Error('No available data');
        }
        const data = await response.json();
        userData.value = data;
    } catch (error: any) {
        console.error('Error fetching data:', error.message);
    }
});

const router = useRouter()
const handleSubmit = async () => {
    let updatedValues = {
        title: title.value,
        description: description.value,
        creator: {
            id: creator.value
        },
        closedBy: {
            id: closedBy.value
        },
        assignee: {
            id: assignee.value
        },
        status: status.value,
        priority: priority.value,
        createdAt: createdAt.value,
        deadline: deadline.value,
    }

    await fetch(`/api/tickets/update`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedValues)
    });

    router.push("/tickets")
}


</script>
  
<style lang="scss">
@import "@/assets/scss/variables.scss";

.create-wrapper {
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
            margin-left: 30px;

            .create-key {
                font-size: 24px;
                line-height: 28px;
                font-weight: 400;

                margin-top: 40px;
                margin-bottom: 40px;
                margin-left: 30px;
            }

            .id {
                margin-top: 50px;
                margin-left: 30px;
            }

            .details-view-wrapper {
                margin-left: 30px;

                .ticekt-detail-view.details-vieww {
                    display: flex;
                    flex-direction: column;
                    gap: 20px;

                    .detail-value {
                        // display: flex;
                        // gap: 20px;
                        // flex-basis: 20;
                        display: flex;
                        align-items: center;
                        flex-flow: row;

                        &>:first-child {
                            font-size: 14px;
                            line-height: 24px;
                            letter-spacing: -0.042px;
                            font-weight: 600;
                            // color: var(--ds-text-subtle, #344563);
                            max-width: 170px;
                            flex-basis: 40%;
                            margin-bottom: 0px;
                            margin-left: 0px;
                            // padding: var(--ds-space-100, 8px) 0;
                            // line-height: 24px;
                            // margin-top: var(--ds-space-100, 8px);
                            // margin-right: var(--ds-space-100, 8px);
                        }

                        &>:nth-child(2) {
                            font-size: 14px;
                            line-height: 20px;
                            font-weight: 400;

                            flex-grow: 1;
                            flex-basis: 60%;

                            max-width: 100%;

                            // .inpp {
                            input[type="text"] {
                                border: none;
                                background: rgb(153, 156, 153);
                                margin: 0;
                                // padding: 8px 15px;
                                font-family: inherit;
                                // font-weight: 400;
                                // font-size: 15px;
                                color: black;
                                border-radius: inherit;
                                // color: rgb(92, 92, 92);
                            }

                            input[type="date"] {
                                border: none;
                                background: transparent;
                                margin: 0;
                                // padding: 8px 15px;
                                font-family: inherit;
                                // font-weight: 400;
                                // font-size: 15px;
                                color: inherit;
                                border-radius: inherit;
                                // color: rgb(92, 92, 92);
                            }

                            input::placeholder {
                                color: #fff;
                                // font-weight: 400;
                                // font-size: 15px;
                            }

                            input:focus {
                                // box-shadow: 0 0 3px 0 rgb(15, 171, 220);
                                // border-color: #1183d6;
                                outline: none;
                            }

                            &.title {
                                input {
                                    // height: 50px;
                                    font-size: 24px;
                                    line-height: 28px;
                                    font-weight: 400;
                                    // color: lightgreen;
                                    // margin-bottom: 40px;
                                }
                            }

                            select {
                                background-color: $btn-dark-100;
                                padding: 4px 8px;
                                border: 1px solid $bg-dark-300;
                                border-radius: 6px;
                                box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
                                // color: $text-white-100;
                                color: inherit;

                                option {
                                    &.High {
                                        color: coral;
                                        color: #ff7d8e;
                                        color: #FF6347;
                                        color: #FF5757;
                                    }

                                    &.Medium {
                                        color: #87CEEB;
                                        color: #FFA500;
                                        color: #FFD700;
                                        color: orange;
                                        color: #EFB465;
                                    }

                                    &.Low {
                                        color: #87CEEB;
                                        color: #3FCD45;
                                        color: #90ee90;
                                    }

                                    &.open {
                                        color: #87CEEB;
                                    }

                                    &.inProgress {
                                        color: #90ee90;
                                    }

                                    &.closed {
                                        color: #FF5757;
                                    }
                                }
                            }

                            // }
                        }

                    }
                }
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