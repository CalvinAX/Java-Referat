<template>
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
</style>