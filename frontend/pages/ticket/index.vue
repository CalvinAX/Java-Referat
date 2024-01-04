<template>
    <div class="ticket-page">
        <div class="ticket-grid">
            <div class="ticket head">
                <span>{{ $t('ticket.title') }}</span>
                <span>{{ $t('ticket.description') }}</span>
                <span>{{ $t('ticket.creator') }}</span>
                <span>{{ $t('ticket.closed_by') }}</span>
                <span>{{ $t('ticket.assignee') }}</span>
                <span>{{ $t('ticket.status') }}</span>
                <span>{{ $t('ticket.priority') }}</span>
            </div>
            <div v-for="result in resultObject" key="result.id">
                <Ticket class="ticket" :result="result" />
            </div>
        </div>

    </div>
</template>

<script setup lang="ts">
const resultObject = ref([{
    id: "1",
    title: "Wichtige Fehlerbehebung",
    description: "Ein kritischer Fehler muss behoben werden, der das System beeinträchtigt.",
    creator: "Maria",
    closed_by: null, // Noch nicht geschlossen
    assignee: "Alex",
    status: "Open",
    priority: "High"
},
{
    id: "2",
    title: "Neue Funktionalität hinzufügen",
    description: "Es soll eine neue Funktion implementiert werden, um die Benutzererfahrung zu verbessern.",
    creator: "Chris",
    closed_by: null, // Noch nicht geschlossen
    assignee: "Sarah",
    status: "In Progress",
    priority: "Medium"
},
{
    id: "3",
    title: "Benutzeroberfläche optimieren",
    description: "Die Benutzeroberfläche muss für eine bessere Benutzerfreundlichkeit optimiert werden.",
    creator: "Alice",
    closed_by: null, // Noch nicht geschlossen
    assignee: "Bob",
    status: "Open",
    priority: "Medium"
},
{
    id: "4",
    title: "Sicherheitspatch anwenden",
    description: "Es muss ein Sicherheitspatch angewendet werden, um bekannte Schwachstellen zu beheben.",
    creator: "David",
    closed_by: null, // Noch nicht geschlossen
    assignee: "Eva",
    status: "In Progress",
    priority: "High"
},
{
    id: "5",
    title: "Dokumentation aktualisieren",
    description: "Die Dokumentation muss auf den neuesten Stand gebracht werden, um Änderungen zu reflektieren.",
    creator: "Grace",
    closed_by: "John",
    assignee: "John",
    status: "Closed",
    priority: "Low"
}])
</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.ticket-page {
    background-color: lightblue;
    min-height: 100%;

    
    .ticket-grid {
        padding-top: 10px;
        margin-inline: 15px;
        display: grid;
        gap: 15px;

        .ticket {
            display: grid;
            grid-template-columns: repeat(7, 1fr);
            grid-template-columns: 1fr 2fr 1fr 1fr 1fr 1fr 1fr;
            grid-template-columns: min(200px) min(300px) 1fr 1fr 1fr 1fr 1fr;
            padding: 5px 15px;
            gap: 5px;
        }

        .ticket.head {
            font-weight: 500;
        }
    }
}
</style>


<!-- 
$brand-color: #4f46e5;

$bg-dark-100: #111827;
$bg-dark-200: #202837;
$bg-dark-300: #101012;
$bg-dark-400: #0f172a;

$btn-dark-100: #29333d;

$btn-hover-100: #1f2937;

$text-white-100: #fbfbfb;
$text-white-200: #9ca3af;
$text-white-300: #79808d;
 -->