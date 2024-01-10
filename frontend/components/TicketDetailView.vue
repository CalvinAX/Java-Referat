<template>
    <div class="ticekt-detail-view">
        <form>
            <div class="details-view">
                <div class="key">
                    <span>{{ result.title }}</span>
                </div>
                <div class="detail-value">
                    <div>Description</div>
                    <div>{{ result.description }}</div>
                </div>
                <div class="detail-value">
                    <div>Creator</div>
                    <div>{{ result.creator.name }}</div>
                </div>
                <div class="detail-value">
                    <div>Closed by</div>
                    <div>{{ result.closedBy.name ? result.closedBy.name : "not closed" }}</div>

                </div>
                <div class="detail-value">
                    <div>Assignee</div>
                    <div>{{ result.assignee.name }}</div>
                </div>
                <div class="detail-value">
                    <div>Status</div>
                    <div class="cell" :class="{
                        open: result.status === 'Open',
                        inProgress: result.status === 'In Progress',
                        closed: result.status === 'Closed'
                    }">{{ result.status }}</div>
                </div>
                <div class="detail-value">
                    <div>Priority</div>
                    <div class="cell" :class="`${result.priority}`">{{ result.priority }}</div>
                </div>
                <div class="detail-value">
                    <div>Created at</div>
                    <div>{{ result.createdAt }}</div>
                </div>
                <div class="detail-value">
                    <div>Deadline</div>
                    <div>{{ result.deadline }}</div>
                </div>
            </div>
        </form>
    </div>
</template>

<script setup lang="ts">
const props = defineProps(['result'])
// const result = ref(props.result);
const result = toRef(props, 'result');
</script>

<style lang="scss">
.ticekt-detail-view {
    .details-view {
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
            }

        }

        .key {
        font-size: 24px;
        line-height: 28px;
        font-weight: 400;

        margin-bottom: 40px;
        // margin-left: 30px;
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
    }
}
</style>