<template>
    <div class="ticket-comp">
        <!-- <NuxtLink :to="`/tickets/${result.id}`"> -->
        <NuxtLink :to="{ path: `/tickets/${result.id}` }">
            <span class="cell">{{ result.title }}</span>
        </NuxtLink>
        <span class="cell">{{ result.creator.name }}</span>
        <span class="cell">{{ result.assignee.name }}</span>
        <span class="cell" :class="{
            open: result.status === 'Open',
            inProgress: result.status === 'In Progress',
            closed: result.status === 'Closed'
        }">{{ result.status }}</span>
        <span class="cell" :class="`${result.priority}`">{{ result.priority }}</span>
        <!-- <span class="cell">{{ result.created_at }}</span> -->
        <span class="cell">{{ result.createdAt }}</span>
        <span class="cell">{{ result.deadline }}</span>
    </div>
</template>

<script setup lang="ts">
const props = defineProps(['result'])
const result = ref(props.result);
</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.ticket-comp {
    .cell {
        padding-left: 8px;

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
</style>