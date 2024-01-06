<template>
    <div class="ticekt-detail-view details-view">
        {{ updatedValues }}
        {{ submit }}
        <div>
            <div>Description</div>
            <div class="inp"><input v-model="description" type="text" :placeholder="result.description"></div>
        </div>
        <div>
            <div>Creator</div>
            <div>{{ result.creator }}</div>
        </div>
        <div>
            <div>Closed by</div>
            <div>{{ result.closedBy ? result.closedBy : "not closed" }}</div>

        </div>
        <div>
            <div>Assignee</div>
            <div class="inp"><input v-model="assignee" type="text" :placeholder="result.assignee"></div>
        </div>
        <div>
            <div>Status</div>
            <!-- <div class="cell" :class="{
                open: result.status === 'Open',
                inProgress: result.status === 'In Progress',
                closed: result.status === 'Closed'
            }">{{ result.status }}</div> -->
            <span>
                <select v-model="status" id="priority" name="priority">
                    <option value="Open" class="open">Open</option>
                    <option value="In Progress" class="inProgress">In Progress</option>
                    <option value="Closed" class="closed">Closed</option>
                </select>
            </span>
        </div>
        <div>
            <div>Priority</div>
            <!-- <div class="cell" :class="`${result.priority}`">{{ result.priority }}</div> -->
            <!-- <label for="cars">Wähle ein Auto:</label> -->
            <span>
                <select v-model="priority" id="priority" name="priority">
                    <option value="Low" class="Low">Low</option>
                    <option value="Medium" class="Medium">Medium</option>
                    <option value="High" class="High">High</option>
                </select>
            </span>
        </div>
        <div>
            <div>Created at</div>
            <div>{{ result.createdAt }}</div>
        </div>
        <div>
            <div>Deadline</div>
            <div class="inp"><input v-model="deadline" type="text" :placeholder="result.deadline"></div>
        </div>
    </div>
</template>

<script setup lang="ts">
const props = defineProps(['result', 'submit'])
const result = ref(props.result);
// const submit = ref(props.submit);
const submit = toRef(props, 'submit');

const emit = defineEmits(['updated'])

const responseData = ref()

// v-model
const title = ref<string | null>(result.value.title);
const description = ref<string | null>(result.value.description);
const creator = ref<string | null>(result.value.creator);
const closedBy = ref<string | null>(result.value.closedBy);
const assignee = ref<string | null>(result.value.assignee);
const status = ref<string | null>(result.value.status);
const priority = ref<string | null>(result.value.priority);
const createdAt = ref<string | null>(result.value.createdAt);
const deadline = ref<string | null>(result.value.deadline);

const updatedValues = ref({})

if (responseData) {
    updatedValues.value = {
        title: title.value,
        description: description.value,
        creator: creator.value,
        closedBy: closedBy.value,
        assignee: assignee.value,
        status: status.value,
        priority: priority.value,
        createdAt: createdAt.value,
        deadline: deadline.value,
    }
}

// onMounted(async () => {

// });
watch(submit, async () => {
    if (submit.value) {
        try {
            await fetch(`/api/tickets/update`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedValues.value)
            });

            emit('updated', updatedValues.value)

        } catch (error: any) {
            console.error('Error fetching data:', error.message);
        }
    }
});


</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.ticekt-detail-view.details-view {
    display: flex;
    flex-direction: column;
    gap: 20px;

    &>div {
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
        }

    }

    .cell {
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

    .inp {
        // display: flex;
        // justify-content: flex-start;
        // margin-top: 20px;
        // margin-bottom: 8px;

        // form {
        //     color: white;
        //     background: #ffffff11;
        //     backdrop-filter: blur(10px);
        //     display: flex;
        //     justify-content: space-between;
        //     // padding: 2px;
        //     border-radius: 6px;
        //     // width: 100%;
        //     // margin: 0 25px;

        input {
            border: none;
            background: transparent;
            margin: 0;
            // padding: 8px 15px;
            font-family: inherit;
            // font-weight: 400;
            // font-size: 15px;
            color: inherit;
            border-radius: inherit;
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
}
</style>